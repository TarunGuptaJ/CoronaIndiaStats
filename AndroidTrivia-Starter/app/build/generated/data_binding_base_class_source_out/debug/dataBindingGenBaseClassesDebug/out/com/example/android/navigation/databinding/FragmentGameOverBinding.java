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

public abstract class FragmentGameOverBinding extends ViewDataBinding {
  @NonNull
  public final ConstraintLayout gameOverConstraintLayout;

  @NonNull
  public final ImageView gameOverFragment;

  @NonNull
  public final Button tryAgainButton;

  protected FragmentGameOverBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ConstraintLayout gameOverConstraintLayout, ImageView gameOverFragment,
      Button tryAgainButton) {
    super(_bindingComponent, _root, _localFieldCount);
    this.gameOverConstraintLayout = gameOverConstraintLayout;
    this.gameOverFragment = gameOverFragment;
    this.tryAgainButton = tryAgainButton;
  }

  @NonNull
  public static FragmentGameOverBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentGameOverBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentGameOverBinding>inflate(inflater, com.example.android.navigation.R.layout.fragment_game_over, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentGameOverBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentGameOverBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentGameOverBinding>inflate(inflater, com.example.android.navigation.R.layout.fragment_game_over, null, false, component);
  }

  public static FragmentGameOverBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentGameOverBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentGameOverBinding)bind(component, view, com.example.android.navigation.R.layout.fragment_game_over);
  }
}
