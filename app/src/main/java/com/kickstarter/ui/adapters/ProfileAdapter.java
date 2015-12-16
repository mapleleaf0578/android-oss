package com.kickstarter.ui.adapters;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.View;

import com.kickstarter.R;
import com.kickstarter.models.Project;
import com.kickstarter.ui.viewholders.KSViewHolder;
import com.kickstarter.ui.viewholders.ProjectCardViewHolder;

import java.util.List;

public final class ProfileAdapter extends KSAdapter {
  private final Delegate delegate;

  public interface Delegate extends ProjectCardViewHolder.Delegate {}

  public ProfileAdapter(final @NonNull Delegate delegate) {
    this.delegate = delegate;
  }

  public void takeProjects(final @NonNull List<Project> projects) {
    data().clear();
    data().add(projects);
    notifyDataSetChanged();
  }

  protected @LayoutRes
  int layout(@NonNull final SectionRow sectionRow) {
    return R.layout.project_card_view;
  }

  protected KSViewHolder viewHolder(final @LayoutRes int layout, final @NonNull View view) {
    return new ProjectCardViewHolder(view, delegate);
  }
}