/*
 * Created by LuaView.
 * Copyright (c) 2017, Alibaba Group. All rights reserved.
 *
 * This source code is licensed under the MIT.
 * For the full copyright and license information,please view the LICENSE file in the root directory of this source tree.
 */
package com.iqyi.paopao.dynamicuisdk.global;

import android.content.Context;

import com.iqyi.paopao.dynamicuisdk.util.AndroidUtil;

/**
 * 常量类
 *
 * @author song
 * @date 15/10/26
 */
public class Constants {
    public static float sScale = -1;
    public static final String PARAM_URI = "uri";
    public static final String PAGE_PARAMS = "page_params";

    // asset file prefix for loading luaview.load(ASSET_FILE_PREFIX + "foler/name")
    public static final String ASSET_FILE_PREFIX = "file:///android_asset/";

    //Bundle encrypt and decrypt
    public static final String PUBLIC_KEY_PATH = "luaview/luaview_rsa_public_key.der";
    public static final String PUBLIC_KEY_PATH_MD5 = "luaview/luaview_rsa_public_key.der-md5";
    public static final String PUBLIC_KEY_PATH_PK = "luaview/luaview_rsa_public_key.der-pk";
    public static final String PUBLIC_KEY_PATH_CIPHER = "luaview/luaview_rsa_public_key.der-cipher";


    public static void init(Context context) {
        sScale = AndroidUtil.getDensity(context);
    }
}