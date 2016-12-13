package com.kpi.activity;


import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import com.kpi.adapter.InforMessListView;
import com.kpi.base.BaseActivity;
import com.kpi.bean.InforMess;
import com.storm.kpi.R;
import java.util.ArrayList;

/**
 * 信息资讯
 */
public class InforMessActivity extends BaseActivity {
    private ListView mListView;
    private ArrayList<InforMess> list = new ArrayList<InforMess>();



    @Override
    public int getLayoutID() {
        return R.layout.activity_informess;
    }




    @Override
    public void initView() {
        mListView = (ListView) findViewById(R.id.informess_list);
        InforMess mInforMess = new InforMess();
        mInforMess.setTitles("人工智能成主打 2016谷歌I/O开发者大会内容汇总");
        mInforMess.setAbst("新浪科技讯，5月19日凌晨消息，谷歌公司(Google)今日在美国旧金山召开Google I/O 2016年度开发者大会。发布新的智能助手，智能家居产品等。我们难得在著名理工男谷歌的发布会上看到一次文艺开场，Google I/O这场发布会居然从一段5分钟live house音乐表演开始。然后陆续发布产品。");
        list.add(mInforMess);
        InforMess mInforMess1 = new InforMess();
        mInforMess1.setTitles("人工智能成主打 2016谷歌I/O开发者大会内容汇总");
        mInforMess1.setAbst("新浪科技讯，5月19日凌晨消息，谷歌公司(Google)今日在美国旧金山召开Google I/O 2016年度开发者大会。发布新的智能助手，智能家居产品等。我们难得在著名理工男谷歌的发布会上看到一次文艺开场，Google I/O这场发布会居然从一段5分钟live house音乐表演开始。然后陆续发布产品。");
        list.add(mInforMess1);
        InforMess mInforMess2 = new InforMess();
        mInforMess2.setTitles("人工智能成主打 2016谷歌I/O开发者大会内容汇总");
        mInforMess2.setAbst("新浪科技讯，5月19日凌晨消息，谷歌公司(Google)今日在美国旧金山召开Google I/O 2016年度开发者大会。发布新的智能助手，智能家居产品等。我们难得在著名理工男谷歌的发布会上看到一次文艺开场，Google I/O这场发布会居然从一段5分钟live house音乐表演开始。然后陆续发布产品。");
        list.add(mInforMess2);
        InforMess mInforMess3 = new InforMess();
        mInforMess3.setTitles("人工智能成主打 2016谷歌I/O开发者大会内容汇总");
        mInforMess3.setAbst("新浪科技讯，5月19日凌晨消息，谷歌公司(Google)今日在美国旧金山召开Google I/O 2016年度开发者大会。发布新的智能助手，智能家居产品等。我们难得在著名理工男谷歌的发布会上看到一次文艺开场，Google I/O这场发布会居然从一段5分钟live house音乐表演开始。然后陆续发布产品。");
        list.add(mInforMess3);

        InforMessListView inforlist = new InforMessListView(this, list);
        mListView.setAdapter(inforlist);
    }





    @Override
    public void initListener() {

    }


    @Override
    public void initData() {

    }

    @Override
    public void initToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.informess_toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("");
            getSupportActionBar().setHomeAsUpIndicator(R.mipmap.left);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
}
