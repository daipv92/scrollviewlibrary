package com.reviewmobileapps.scrollviewlib.items;

public interface IScrollViewItem {

    enum Type {
        GRAVITY_SETTING,
        // for shape
        SHAPE_SETTING,

        // setting border.
        SETTING,

        // seting finger
        FINGER_SETTING,

        // rotation
        ROTATION_SETTING,
    }

    enum ViewType {
        IMAGE_BUTTON,
        THUMBNAIL
    }

    Type getType();

    ViewType getViewType();
}
