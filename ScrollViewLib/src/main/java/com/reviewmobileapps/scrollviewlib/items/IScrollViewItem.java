package com.reviewmobileapps.scrollviewlib.items;

public interface IScrollViewItem {

    enum Type {
        GRAVITY_SETTING,
        EDIT_GRAVITY_BACKGROUND,
        EDIT_GRAVITY_MARK,
        CHANGE_GRAVITY_BACKGROUND,
        CHANGE_GRAVITY_MARK,
        // for shape
        SHAPE_SETTING,
        SHAPE_CIRCLE,
        SHAPE_RECTANGLE,
        SHAPE_HEART,
        SHAPE_STAR,
        SHAPE_LIKE,
        SHAPE_TRACK_CHANGE,
        SHAPE_SENTIMENT_SATISFIED,
        SHAPE_SENTIMENT_DISSATISFIED,
        SHAPE_WAVES,
        SHAPE_MOOD_BAD,

        // setting border.
        SETTING,
        BORDER_SETTING,
        FINGER_ENABLE_SETTING,

        // seting finger

        FINGER_SETTING,
        FINGER_OFF,
        FINGER_BRUSH_SIZE,
        FINGER_CHANGE_BRUSH_SIZE,
        FINGER_UNDO,
        FINGER_REDO,

        // rotation
        ROTATION_SETTING,
        ROTATE_LEFT,
        ROTATE_RIGHT
    }

    enum ViewType {
        IMAGE_BUTTON,
        SHAPE_THUMBNAIL,
        THUMBNAIL
    }

    Type getType();

    ViewType getViewType();
}
