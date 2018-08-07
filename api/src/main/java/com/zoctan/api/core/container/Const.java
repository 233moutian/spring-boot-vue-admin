package com.zoctan.api.core.container;

public class Const {

	public static final String PAYMENT_JOB_GROUP = "paymentJobGroup";
	public static final String GET_PAYMENT_RESULT_JOB = "getPaymentResultJob";

	public static final String GET_PAYMENT_RESULT_TRIGGER = "getPaymentResultTrigger";
	public static final String PAYMENT_TRIGGER_GROUP = "payTriggerGroup";

	public static final String MESSAGE = "message";
	
	public static final String SESSION_IDENTITY = "sessionUser";
	
	public static final String SUCCESS = "succ";
	public static final Integer STATES_FORBID = -2;    //禁用
	
	public static final Integer STATES_AUDIT_FAILED = -1;     //审核不通过
	
	public static final Integer STATES_DRAFT = 0;      //草稿
	
	public static final Integer STATES_SUBMIT = 1;   //提交待审核
	
	public static final Integer STATES_AUDIT_SUCC = 2;   //审核通过
	
	public static final Integer STATES_INSERT_ERR = 3;   //审核通过，但是数据插入失败
	
	public static final Integer STATES_EXECUTED = 4; //执行成功
	
	public static final Integer STATES_DONE = 5; //完成所有步骤
	
	public static final Integer ENABLED = 0;     
	
	public static final Integer DISABLED = 1;
	
	public static final Integer SYSADMIN = 1;    //管理员
	
	public static final Integer NORMAL_USER =  2;   //普通用户
	
	public static final Integer CONFIG_TYPE_PC = 0;
	
	public static final Integer CONFIG_TYPE_WEB = 1;
	
	public static final Integer CONFIG_TYPE_ACCOUNT = 2;
	
	public static final Integer CONFIG_TYPE_MOBILE = 3;
	
	/**
	 * AES加密的公共KEY
	 */
	public static final String AES_KEY="QQRTKKIOHGFVCXQO";
	
}
