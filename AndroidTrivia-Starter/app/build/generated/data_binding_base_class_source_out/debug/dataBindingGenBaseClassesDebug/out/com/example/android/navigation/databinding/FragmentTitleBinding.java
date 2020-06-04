package com.example.android.navigation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class FragmentTitleBinding extends ViewDataBinding {
  @NonNull
  public final Button playButton;

  @NonNull
  public final ConstraintLayout titleConstraint;

  @NonNull
  public final ImageView titleImage;

  protected FragmentTitleBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Button playButton, ConstraintLayout titleConstraint,
      ImageView titleImage) {
    super(_bindingComponent, _root, _localFieldCount);
    this.playButton = playButton;
    this.titleConstraint = titleConstraint;
    this.titleImage = titleImage;
  }

  @NonNull
  public static FragmentTitleBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentTitleBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentTitleBinding>inflate(inflater, com.example.android.navigation.R.layout.fragment_title, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentTitleBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentTitleBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentTitleBinding>inflate(inflater, com.example.android.navigation.R.layout.fragment_title, null, false, component);
  }

  public static FragmentTitleBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentTitleBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentTitleBinding)bind(component, view, com.example.android.navigation.R.layout.fragment_title);
  }
}
