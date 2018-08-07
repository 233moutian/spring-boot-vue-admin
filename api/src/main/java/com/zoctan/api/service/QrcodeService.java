package com.zoctan.api.service;

import com.zoctan.api.core.response.Result;
import com.zoctan.api.core.service.Service;
import com.zoctan.api.model.pay.QrcodeItem;

/**
 * Created by zxw on 2018/8/6 0006.
 * 二维码业务接口
 */
public interface QrcodeService extends Service<QrcodeItem> {

    Result addQrcode(QrcodeItem qrcodeItem);

    Result getQrcode(String money, String sign);

}
