package com.example.user.utils.weight.numal;

import android.widget.AbsListView;
import android.widget.ListView;

import java.util.HashSet;
import java.util.Set;

/**
 * 项目名称：AndroidUtils
 * 类描述：SwipeSlideListener 描述: 侧滑删除layout的监听器  侧滑Layout
 * 创建人：songlijie
 * 创建时间：2017/5/17 11:58
 * 邮箱:814326663@qq.com
 */
public class SwipeSlideListener implements SwipeListLayout.OnSwipeStatusListener {
    private Set<SwipeListLayout> sets = new HashSet();
    private SwipeListLayout slipListLayout;
    public SwipeSlideListener(SwipeListLayout slipListLayout) {
        this.slipListLayout = slipListLayout;
    }
    @Override
    public void onStatusChanged(SwipeListLayout.Status status) {
        if (status == SwipeListLayout.Status.Open) {
            //若有其他的item的状态为Open，则Close，然后移除
            if (sets.size() > 0) {
                for (SwipeListLayout s : sets) {
                    s.setStatus(SwipeListLayout.Status.Close, true);
                    sets.remove(s);
                }
            }
            sets.add(slipListLayout);
        } else {
            if (sets.contains(slipListLayout)){
                sets.remove(slipListLayout);
            }
        }
    }

    @Override
    public void onStartCloseAnimation() {

    }

    @Override
    public void onStartOpenAnimation() {

    }

    /**
     * 设置listview的滑动监听
     * @param view
     */
    public void ListViewScroll(ListView view){
        view.setOnScrollListener(new AbsListView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                switch (scrollState) {
                    //当listview开始滑动时，若有item的状态为Open，则Close，然后移除
                    case SCROLL_STATE_TOUCH_SCROLL:
                        if (sets.size() > 0) {
                            for (SwipeListLayout s : sets) {
                                s.setStatus(SwipeListLayout.Status.Close, true);
                                sets.remove(s);
                            }
                        }
                        break;

                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {

            }
        });
    }
}
