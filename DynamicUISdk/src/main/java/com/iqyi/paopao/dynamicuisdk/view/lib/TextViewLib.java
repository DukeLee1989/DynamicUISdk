package com.iqyi.paopao.dynamicuisdk.view.lib;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AndroidException;
import android.view.Gravity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.iqyi.paopao.dynamicuisdk.utils.ViewUtil;
import com.iqyi.paopao.dynamicuisdk.view.lib.base.BaseFunctionLib;

import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.TwoArgFunction;
import org.luaj.vm2.lib.ZeroArgFunction;
import org.luaj.vm2.lib.jse.CoerceJavaToLua;
import org.luaj.vm2.lib.jse.CoerceLuaToJava;

/**
 * Created by liuhonghai on 2017/9/12.
 */

public class TextViewLib extends BaseFunctionLib {

    private Context mContext;

    public TextViewLib(Context context) {
        super("LTextView");
        mContext=context;
    }

    @Override
    public LuaValue createLuaTable(LuaValue env, LuaValue metaTable) {
        metaTable.set("newTextView", new TextViewLib.NewTextView());
        return metaTable;
    }

    private class NewTextView extends ZeroArgFunction {
        @Override
        public LuaValue call() {
            LTextView textView=new LTextView(mContext);
            return CoerceJavaToLua.coerce(textView);
        }
    }

    public class LTextView extends android.support.v7.widget.AppCompatTextView{
        public static final int CENTER = Gravity.CENTER;
        public static final int CENTER_HORIZONTAL = Gravity.CENTER_HORIZONTAL;
        public static final int CENTER_VERTICAL = Gravity.CENTER_VERTICAL;

        public static final int LEFT = Gravity.LEFT;

        public LTextView(Context context) {
            super(context);
            ViewUtil.setId(this);
        }

        public void setLSingleLine(){
            this.setMaxLines(1);
            this.setEllipsize(TextUtils.TruncateAt.END);
        }

        public void setLTextBold(){
            this.setTypeface(Typeface.DEFAULT_BOLD);
        }

        public void setLTextColor(String colorString){
            this.setTextColor(Color.parseColor(colorString));
        }

        public void setLTextSize(float size){
            this.setTextSize(size);
        }



    }
}
