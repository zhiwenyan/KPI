package com.kpi.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * sp管理类，提供对sp操作的包装
 * Created by Forest on 2016/4/25.
 */
public class PreferencesManager {
    // ============================== 文件名 ====================================

    public static final String DEFAULT_SHAREPREFERENCES_FILE = "default_cfg";

    private SharedPreferences mPraferences;
    private Editor mEditor;
    private PreferencesManager(){

    }
    /**
     * 获取默认的sp文件default_cfg.xml，默认模式为Content。MODE_PRIVATE
     * @param context
     * @return
     */
    public static PreferencesManager getDefaultSharedPreference(Context context){

        return getSharedPreference(context,
                DEFAULT_SHAREPREFERENCES_FILE,
                Context.MODE_PRIVATE);
    }

    /**
     * 获取sp
     *
     * @param context
     * @param name
     *            文件名称
     * @param mode
     *            模式
     * @return
     */

    public static PreferencesManager getSharedPreference(Context context,
                                                         String name, int mode){

        if(context != null){
            try {
                PreferencesManager preferencesManager = new PreferencesManager();
                preferencesManager.mPraferences = context.getSharedPreferences(
                        name,mode);
                preferencesManager.mEditor = preferencesManager.mPraferences.edit();
                return preferencesManager;
            } catch (Exception e){

            }
        }
        return null;
    }
}
