package com.zoctan.api.core.container;

/**
 * Created by zxw on 2018/7/13 0013.
 * 系统统一常量类
 */
public enum SystemEnums {
    FALSE("false", "表示false"),
    TRUE("true", "表示true"),
    ZERO("0", "表示0"),
    ONE("1", "表示1"),
    // 网上支付平台返回码
    ReturnCode_0000("0000", "交易成功"),
    // htpay系统全局状态码
    RESPONSE_Code_500("500", "系统异常"),
    RESPONSE_Code_566("566", "数组异常"),
    RESPONSE_Code_600("600", "parm为空!"),
    RESPONSE_Code_0("0", "操作成功"),

    ACTIVEMQ_QUEUE_HT_RT_QRCODE("QRCODE", "htpay.retransmission.qrcode"),
    //  固定模块接口返回码--以下为二维码模块
    RESPONSE_Code_801001("801001", "签名验证不通过!"),
    RESPONSE_Code_801002("801002", "redis插入失败!"),
    RESPONSE_Code_801003("801003", "mysql插入失败!"),
    RESPONSE_Code_801004("801004", "此金额的二维码已用完!"),
    RESPONSE_Code_801005("801005", "此二维码已经存过了!"),

    //  固定模块接口返回码--以下为订单交易查询模块
    RESPONSE_Code_700001("700001", "订单交易查询模块,设定交易类型不合法"),
    RESPONSE_Code_700002("700002", "订单交易查询模块,未设定交易编号"),
    RESPONSE_Code_700003("700003", "订单交易查询模块,交易编号不合法"),
    // 固定模块接口返回码--以下为支付模块
    RESPONSE_Code_600001("600001", "支付模块,支付通知类型不合法"),
    RESPONSE_Code_600002("600002", "支付模块,支付结果回传网址不合法"),
    RESPONSE_Code_600003("600003", "支付模块,支付结果回传网址不合法"),
    RESPONSE_Code_600004("600004", "支付模块,支付结果回传网址不合法"),
    RESPONSE_Code_600005("600005", "支付模块,附言长度大于100"),
    RESPONSE_Code_600006("600006", "支付模块,设定交易类型错误"),
    RESPONSE_Code_600007("600007", "支付模块,分期标识为空或输入非法"),
    RESPONSE_Code_600008("600008", "支付模块,分期代码长度应该为8位"),
    RESPONSE_Code_600009("600009", "支付模块,分期期数非有效数字或者长度超过2"),
    RESPONSE_Code_600010("600010", "支付模块,交易类型为直接支付或预授权支付时，分期标识不允许输入为“1”"),
    RESPONSE_Code_600011("600011", "支付模块,交易编号为空"),
    RESPONSE_Code_600012("600012", "支付模块,交易编号超长"),
    RESPONSE_Code_600013("600013", "支付模块,订单日期不合法"),
    RESPONSE_Code_600014("600014", "支付模块,订单时间不合法"),
    RESPONSE_Code_600015("600015", "支付模块,商品种类不合法"),
    RESPONSE_Code_600016("600016", "支付模块,订单金额不合法"),
    RESPONSE_Code_600017("600017", "支付模块,设定交易币种错误"),
    RESPONSE_Code_600018("600018", "支付模块,分账信息不合法"),
    RESPONSE_Code_600019("600019", "支付模块,分账信息不合法"),
    RESPONSE_Code_600020("600020", "支付模块,分账标志为0时，不能设置分账信息"),
    RESPONSE_Code_600021("600021", "支付模块,指定支付账户为空"),
    RESPONSE_Code_600022("600022", "支付模块,支付账户不合法"),
    RESPONSE_Code_600023("600023", "支付模块,手机号未设置"),
    RESPONSE_Code_600024("600024", "支付模块,手机号长度不合法"),
    RESPONSE_Code_600025("600025", "支付模块,手机号不合法"),
    RESPONSE_Code_600026("600026", "支付模块,商品种类未设定"),
    RESPONSE_Code_600027("600027", "支付模块,分期标识未设定"),
    RESPONSE_Code_600028("600028", "支付模块,支付类型未设定"),
    RESPONSE_Code_600029("600029", "支付模块,支付渠道未设定"),
    RESPONSE_Code_600030("600030", "支付模块,交易类型未设定"),
    RESPONSE_Code_600031("600031", "支付模块,交易类型不合法"),
    RESPONSE_Code_600032("600032", "支付模块,交易编号为空或超过长度限制"),
    RESPONSE_Code_600033("600033", "支付模块,订单金额未设定"),
    RESPONSE_Code_600034("600034", "支付模块,订单金额小于等于零"),
    RESPONSE_Code_600035("600035", "支付模块,订单说明超长"),
    RESPONSE_Code_600036("600036", "支付模块,交易币种未设定"),
    RESPONSE_Code_600037("600037", "支付模块,交易币种不合法"),
    RESPONSE_Code_600038("600038", "支付模块,分账信息不合法"),
    RESPONSE_Code_600039("600039", "支付模块,指定支付账户为空"),
    RESPONSE_Code_601001("601001", "支付模块,指定支付账户为空"),
    RESPONSE_Code_601002("601002", "支付模块,指定支付账户为空"),
    RESPONSE_Code_601003("601003", "支付模块,指定支付账户为空"),
    RESPONSE_Code_601004("601004", "支付模块,指定支付账户为空"),
    RESPONSE_Code_601005("601005", "支付模块,指定支付账户为空"),
    RESPONSE_Code_601006("601006", "支付模块,指定支付账户为空"),
    RESPONSE_Code_601007("601007", "支付模块,指定支付账户为空"),
    RESPONSE_Code_601008("601008", "支付模块,指定支付账户为空"),
    RESPONSE_Code_601009("601009", "支付模块,指定支付账户为空"),
    RESPONSE_Code_601010("601010", "支付模块,指定支付账户为空"),
    RESPONSE_Code_601011("601011", "支付模块,指定支付账户为空"),
    RESPONSE_Code_601012("601012", "支付模块,指定支付账户为空"),
    RESPONSE_Code_601013("601013", "支付模块,指定支付账户为空"),
    RESPONSE_Code_601014("601014", "支付模块,指定支付账户为空"),
    RESPONSE_Code_601015("601015", "支付模块,指定支付账户为空"),
    RESPONSE_Code_601016("601016", "支付模块,指定支付账户为空"),
    RESPONSE_Code_601017("601017", "支付模块,指定支付账户为空"),
    RESPONSE_Code_601018("601018", "支付模块,指定支付账户为空"),
    RESPONSE_Code_601019("601019", "支付模块,指定支付账户为空"),

    RESPONSE_Code_600500("600500", "支付失败,未知异常"),
    // 固定模块接口返回码--以下为商户模块模块
    RESPONSE_Code_500001("500001", "商户模块,PayTypeID 参数异常"),
    // 固定模块接口返回码--以下为退款模块
    RESPONSE_Code_401101("401101", "商户提交的交易资料不合法, 交易金额未设定！"),
    RESPONSE_Code_401102("401102", "商户提交的交易资料不合法, 交易金额不合法！"),
    RESPONSE_Code_401103("401103", "商户提交的交易资料不完整, 设定交易币种不合法！"),
    RESPONSE_Code_401104("401104", "商户提交的交易资料不完整, 订单时间不合法！"),
    RESPONSE_Code_401105("401105", "商户提交的交易资料不完整, 订单日期不合法！"),
    RESPONSE_Code_401106("401106", "商户提交的交易资料不完整, 交易编号不合法！"),
    RESPONSE_Code_401107("401107", "商户提交的交易资料不完整, 原交易编号不合法！"),
    RESPONSE_Code_411101("411101", "商户提交的交易资料不合法, 批次的总笔数超过最大限制"),
    RESPONSE_Code_411102("411102", "批量退款总金额不正确"),
    RESPONSE_Code_411103("411103", "商户提交的交易资料不合法, 批内明细合计金额与批次的总金额不符"),
    RESPONSE_Code_411104("411104", "商户提交的交易资料不完整, 批量编号未设置！"),
    RESPONSE_Code_411105("411105", "商户提交的交易资料不完整, 订单日期不合法！"),
    RESPONSE_Code_411106("411106", "商户提交的交易资料不完整, 订单时间不合法！"),
    RESPONSE_Code_411107("411107", "商户提交的交易资料不完整, 交易总笔数不合法！"),
    RESPONSE_Code_411108("411108", "商户提交的交易资料不合法, 交易总笔数不能小于1笔"),
    RESPONSE_Code_411109("411109", "商户提交的交易资料不合法, 交易总笔数不能大于10000笔"),
    RESPONSE_Code_411110("411110", "商户提交的交易资料不完整, 交易总金额不合法！"),
    RESPONSE_Code_411111("411111", "商户提交的交易资料不合法, 交易总金额保留2位小数！"),
    RESPONSE_Code_411112("411112", "商户提交的交易资料不合法, 交易总金额不能小于0！"),
    RESPONSE_Code_411113("411113", "商户提交的交易资料不合法, 退款订单明细中原交易编号不合法！"),
    RESPONSE_Code_411114("411114", "商户提交的交易资料不合法, 退款订单明细中新交易编号不合法！"),
    RESPONSE_Code_411115("411115", "商户提交的交易资料不合法, 退款订单明细中交易币种不合法！"),
    RESPONSE_Code_411116("411116", "商户提交的交易资料不合法, 退款订单明细中交易币种不合法！"),
    RESPONSE_Code_411117("411117", "商户提交的交易资料不完整, 退款订单明细中交易金额未设置！"),
    RESPONSE_Code_411118("411118", "商户提交的交易资料不合法, 退款订单明细中交易金额不合法！"),
    RESPONSE_Code_411119("411119", "商户提交的交易资料不合法, 退款订单明细中交易金额不合法！"),
    // 固定模块接口返回码--以下为验证模块
    RESPONSE_Code_100001("100001", "商户提交的交易资料不完整, 客户类型为空"),
    RESPONSE_Code_100002("100002", "商户提交的交易资料不合法, 客户类型不合法"),
    RESPONSE_Code_100003("100003", "商户提交的交易资料不合法, 银行卡号不合法"),
    RESPONSE_Code_100004("100004", "商户提交的交易资料不合法, 证件类型、证件号码不合法"),
    RESPONSE_Code_100005("100005", "商户提交的交易资料不合法, 客户姓名不合法"),
    RESPONSE_Code_100006("100006", "商户提交的交易资料不完整, 手机号不合法"),
    RESPONSE_Code_100007("100007", "商户提交的交易资料不合法, 手机号不合法"),


    // 支付模块 商品种类
    CommodityType_0101("0101", "支付账户充值"),
    CommodityType_0201("0201", "虚拟类"),
    CommodityType_0202("0202", "传统类"),
    CommodityType_0203("0203", "实名类"),
    CommodityType_0301("0301", "本行转账"),
    CommodityType_0302("0302", "他行转账"),
    CommodityType_0401("0401", "水费"),
    CommodityType_0402("0402", "电费"),
    CommodityType_0403("0403", "煤气费"),
    CommodityType_0404("0404", "有限电视费"),
    CommodityType_0405("0405", "通讯费"),
    CommodityType_0406("0406", "物业费"),
    CommodityType_0407("0407", "保险费"),
    CommodityType_0408("0408", "行政费用"),
    CommodityType_0409("0409", "税费"),
    CommodityType_0410("0410", "学费"),
    CommodityType_0499("0499", "其他费用"),
    CommodityType_0501("0501", "基金"),
    CommodityType_0502("0502", "理财产品"),
    CommodityType_0599("0599", "其他"),
    // 微信支付交易类型
    PayTypeID_NATIVE("NATIVE", "原生扫码支付"),
    PayTypeID_JSAPI("JSAPI", "公众号支付"),
    PayTypeID_APP("APP", "app支付"),
    PayTypeID_MICROPAY("MICROPAY", "微信刷卡支付"),
    PayTypeID_MWEB("MWEB", "微信H5支付"),
    // 支付宝支付交易类型
    PayTypeID_ALI_PC("ALI_PC", "网站支付"),
    PayTypeID_ALI_WAP("ALI_WAP", "WAP 支付"),
    PayTypeID_ALI_APP("ALI_APP", "APP 支付"),
    PayTypeID_ALI_PRECREATE("ALI_PRECREATE", "线下主扫支付宝"),
    PayTypeID_ALI_CREATE("ALI_CREATE", "线下静态一码多付"),
    PayTypeID_ALI_PAY("ALI_PAY", "刷卡支付"),
    // 订单交易查询类型
    PayTypeID_QUARY_ImmediatePay("ImmediatePay", "直接支付"),
    PayTypeID_QUARY_PreAuthPay("PreAuthPay", "预授权支付"),
    PayTypeID_QUARY_DividedPay("DividedPay", "分期支付"),
    PayTypeID_QUARY_AgentPay("AgentPay", "授权支付"),
    PayTypeID_QUARY_Refund("Refund", "退款"),
    PayTypeID_QUARY_DefrayPay("ImmediatePay", "付款"),
    PayTypeID_QUARY_PreAuthed("PreAuthed", "预授权确认"),
    PayTypeID_QUARY_PreAuthCancel("PreAuthCancel", "预授权取消"),
    // 支付账户类型
    PaymentType_A("A", "农行卡支付"),
    PaymentType_8("8", "微信支付"),
    // 支付渠道
    PaymentLinkType_1("1", "internet 网络接入"),
    PaymentLinkType_2("2", "手机网络接入"),
    PaymentLinkType_3("3", "数字电视网络接入"),
    PaymentLinkType_4("4", "智能客户端接入"),
    PaymentLinkType_5("5", "线下渠道"),

    // 是否向二级商户入账
    IsBreakAccount_0("0", "否"),
    IsBreakAccount_1("1", "是"),
    // 账户类型
    AccountType_401("401", "借记卡"),
    AccountType_601("401", "支票户"),
    // 账户状态
    AccStatus_0("0", "关闭"),
    AccStatus_1("1", "正常"),
    // 是否农行账户
    IsABCAccount_0("0", "否"),
    IsABCAccount_1("1", "是"),
    // 二级商户类型
    SubMerType_1("1", "个人商户"),
    SubMerType_2("2", "二级商户类型"),
    // 二级商户种类
    SubMerSort_1("1", "普通类商户"),
    SubMerSort_2("2", "自营类商户"),
    SubMerSort_9("9", "其他"),
    // 分期标识 1： 分期； 0：非分期。 交易类型为直接支付或预授权支付时， 分期标识不允许输入为 1
    InstallmentMark_1("1", "分期"),
    InstallmentMark_0("0", "非分期"),
    // 通知方式1
    NotifyType_1("1", "服务器通知"),
    // 法定代表人或负责人证件类型
    CertificateType_I("I", "身份证"),
    CertificateType_P("P", "护照"),
    CertificateType_G("G", "军官证"),
    CertificateType_U("U", "其他证件"),
    CertificateType_Y("Y", "组织机构代码证"),
    CertificateType_V("V", "统一社会信用代码"),
    // 二级商户状态
    Status_0("0", "关闭"),
    Status_1("1", "正常");

/*
//        System.out.println(Enums.PayTypeID_NATIVE.getCode());// 通过枚举类中枚举名获取到枚举的code值——打印NATIVE
//        System.out.println(Enums.map.get(Enums.PayTypeID_NATIVE.getCode()));// 通过枚举类中枚举的code值获取到对应的name描述——打印原生扫码支付


    public static Map<String, String> map = new HashMap<String, String>();

    static {
        SystemEnums[] values = SystemEnums.values();
        if (values.length > 0) {
            for (SystemEnums product : values) {
                map.put(product.getCode(), product.getName());
            }
        }
    }
*/

    SystemEnums(String code, String name) {
        this.code = code;
        this.name = name;
    }

    private String code;

    private String name;

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }


}
