package com.nbteam.hislite.payment.api.pay.vo;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
/**
 * 
 * 参数基础类（所有的voparam都继承这个类）<br/>
 *
 */
public class BaseParamVo implements Serializable {

    /** 
     */  
    private static final long serialVersionUID = -6381198117476248523L;

    /** 医院Id */
    @NotNull(message = "医院Id不能为空")
    private Long hisId;

    /** {@linkplain #hisId} */
    public Long getHisId() {
        return hisId;
    }
    

    /** {@linkplain #hisId} */
    public void setHisId(Long hisId) {
        this.hisId = hisId;
    }
    
    
}
