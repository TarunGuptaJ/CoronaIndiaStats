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

public abstract class FragmentGameWonBinding extends ViewDataBinding {
  @NonNull
  public final ConstraintLayout gameWonConstraintLayout;

  @NonNull
  public final Button nextMatchButton;

  @NonNull
  public final ImageView youWinImage;

  protected FragmentGameWonBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ConstraintLayout gameWonConstraintLayout, Button nextMatchButton,
      ImageView youWinImage) {
    super(_bindingComponent, _root, _localFieldCount);
    this.gameWonConstraintLayout = gameWonConstraintLayout;
    this.nextMatchButton = nextMatchButton;
    this.youWinImage = youWinImage;
  }

  @NonNull
  public static FragmentGameWonBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentGameWonBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentGameWonBinding>inflate(inflater, com.example.android.navigation.R.layout.fragment_game_won, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentGameWonBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentGameWonBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentGameWonBinding>inflate(inflater, com.example.android.navigation.R.layout.fragment_game_won, null, false, component);
  }

  public static FragmentGameWonBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentGameWonBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentGameWonBinding)bind(component, view, com.example.android.navigation.R.layout.fragment_game_won);
  }
}
