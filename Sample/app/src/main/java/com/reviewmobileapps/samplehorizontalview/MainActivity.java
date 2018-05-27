package com.reviewmobileapps.samplehorizontalview;

import android.app.Activity;
import android.os.Bundle;

import com.reviewmobileapps.scrollviewlib.CustomScrollView;
import com.reviewmobileapps.scrollviewlib.ScrollViewCallback;
import com.reviewmobileapps.scrollviewlib.items.IScrollViewItem;
import com.reviewmobileapps.scrollviewlib.items.ThumbnailWithTitleCardItem;

public class MainActivity extends Activity implements ScrollViewCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        CustomScrollView horizontalView = (CustomScrollView) findViewById(R.id.horizontal_view);
        horizontalView.addItem(new ThumbnailWithTitleCardItem(R.drawable.ic_baseline_filter_frames, IScrollViewItem.Type.SHAPE_SETTING, R.string.title_mask));
        horizontalView.addItem(new ThumbnailWithTitleCardItem(R.drawable.ic_baseline_blur_setting, IScrollViewItem.Type.GRAVITY_SETTING, R.string.title_blur_size));
        horizontalView.addItem(new ThumbnailWithTitleCardItem(R.drawable.ic_baseline_settings, IScrollViewItem.Type.SETTING, R.string.title_border_setting));
        horizontalView.addItem(new ThumbnailWithTitleCardItem(R.drawable.ic_baseline_touch_app, IScrollViewItem.Type.FINGER_SETTING, R.string.title_finger_settings));
        horizontalView.addItem(new ThumbnailWithTitleCardItem(R.drawable.ic_baseline_rotation, IScrollViewItem.Type.ROTATION_SETTING, R.string.rotate_setting));
        horizontalView.setHorizontalCallback(this);
        horizontalView.select(0);
    }

    @Override
    public void onClick(IScrollViewItem.Type viewType) {
        // Do something here to handle click each item on CustomScrollView.
    }
}
