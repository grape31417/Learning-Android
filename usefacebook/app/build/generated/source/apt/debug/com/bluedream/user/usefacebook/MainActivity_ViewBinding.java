// Generated code from Butter Knife. Do not modify!
package com.bluedream.user.usefacebook;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  private View view2131165185;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(final MainActivity target, View source) {
    this.target = target;

    View view;
    target.textView = Utils.findRequiredViewAsType(source, R.id.textView, "field 'textView'", TextView.class);
    view = Utils.findRequiredView(source, R.id.API, "field 'API' and method 'onViewClicked'");
    target.API = Utils.castView(view, R.id.API, "field 'API'", Button.class);
    view2131165185 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
    target.share = Utils.findRequiredViewAsType(source, R.id.share, "field 'share'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.textView = null;
    target.API = null;
    target.share = null;

    view2131165185.setOnClickListener(null);
    view2131165185 = null;
  }
}
