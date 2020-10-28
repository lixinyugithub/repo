package com.nbteam.hislite.his.outpatient.service;

import com.nbteam.hislite.his.api.common.constant.HisConstants;
import com.nbteam.hislite.his.api.outpatient.dto.HisOppayOrderSync;
import com.nbteam.hislite.his.outpatient.mapper.HisOppayOrderSyncMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SendSyncService
{
	private static final Logger logger = LoggerFactory.getLogger(SendSyncService.class);

	@Autowired
	private HisOppayOrderSyncMapper hisOppayOrderSyncMapper;
	/**
	 * 获取订单同步表
	 * @param orderId
	 * @param objectId
	 * @param system
	 * @param type
	 * @param bizType
	 * @return
	 */
	public HisOppayOrderSync getOrderSync(Long orderId, Long objectId, String system, String sendType, String bizType) {
		HisOppayOrderSync orderSync = hisOppayOrderSyncMapper.selectByCondition(orderId, objectId, system, sendType);
		if (orderSync == null) {
			orderSync = new HisOppayOrderSync();
			orderSync.setObjectId(objectId);
			orderSync.setOrderId(orderId);
			orderSync.setSystemName(system);
			orderSync.setSendType(sendType);
			orderSync.setBizType(bizType);
			orderSync.setTimes(0);
			orderSync.setStatus(HisConstants.ORDER_SYNC_FAILURE);
		}
		return orderSync;
	}

	/**
	 * 保存同步信息
	 * @param orderSync
	 * @param status
	 */
    public void saveSync(HisOppayOrderSync orderSync, boolean status) {
		orderSync.setStatus(status ? HisConstants.ORDER_SYNC_SUCCESS : HisConstants.ORDER_SYNC_FAILURE);
		if (orderSync.getSendTime() == null) {
			orderSync.setSendTime(new Date());
		}
		orderSync.setTimes(orderSync.getTimes() != null ? (orderSync.getTimes() + 1) : 1);
		persistSync(orderSync);
    }

	/**
	 * 保存同步信息
	 * @param sync
	 */
	private void persistSync(HisOppayOrderSync sync) {
		if (sync.getSyncId() != null) {
			hisOppayOrderSyncMapper.updateByPrimaryKeySelective(sync);
		} else {
			HisOppayOrderSync entity = hisOppayOrderSyncMapper.selectByCondition(sync.getOrderId(), sync.getObjectId(), sync.getSystemName(), sync.getSendType());
			if (entity != null) {
				logger.warn("同步时数据库实体重复,id={}", entity.getSyncId());
				sync.setSyncId(entity.getSyncId());
				hisOppayOrderSyncMapper.updateByPrimaryKeySelective(sync);
			} else {
//				sync.setSyncId(idGenerator.next(IDGeneratorTypeEnum.t_rc_order_sync.name()).id);
				hisOppayOrderSyncMapper.insertSelective(sync);
			}

		}
	}
}
