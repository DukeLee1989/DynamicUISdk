package com.iqyi.paopao.demo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.iqyi.paopao.demo.imageloader.GlideImageLoader;
import com.iqyi.paopao.lua.globals.Constants;
import com.iqyi.paopao.lua.globals.DynamicUIManager;
import com.iqyi.paopao.lua.lib.ActivityLib;
import com.iqyi.paopao.lua.lib.ButtonLib;

import org.luaj.vm2.LuaValue;


public class MainActivity extends Activity {

    private DynamicUIManager mDynamicUIManager;
    private LuaValue chunk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initConfig();
    }

    private void initConfig() {
        Constants.init(this);
        mDynamicUIManager = DynamicUIManager.getInstance();
        RelativeLayout rootView = findViewById(R.id.layout);
        mDynamicUIManager.setContainerView(rootView);

        mDynamicUIManager.setImageLoader(new GlideImageLoader());
        mDynamicUIManager.loadCustomLib(new ButtonLib(), new ActivityLib());//绑定所有需要的组件

        chunk = mDynamicUIManager.loadLuaScript(this, "activitySkip.lua");//加载对应业务的脚本
    }


}
