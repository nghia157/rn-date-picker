package com.henninghall.date_picker.single_picker;

import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.henninghall.date_picker.PickerView;
import com.henninghall.date_picker.props.DateProp;
import com.henninghall.date_picker.props.DividerHeightProp;
import com.henninghall.date_picker.props.FadeToColorProp;
import com.henninghall.date_picker.props.Is24hourSourceProp;
import com.henninghall.date_picker.props.LocaleProp;
import com.henninghall.date_picker.props.MaximumDateProp;
import com.henninghall.date_picker.props.MinimumDateProp;
import com.henninghall.date_picker.props.MinuteIntervalProp;
import com.henninghall.date_picker.props.ModeProp;
import com.henninghall.date_picker.props.TextColorProp;
import com.henninghall.date_picker.props.UtcProp;
import com.henninghall.date_picker.props.VariantProp;

import java.lang.reflect.Method;
import java.util.Map;

public class SingleDatePickerManager extends SimpleViewManager<SingleDateAndTimePicker> {

  private static final String REACT_CLASS = "SingleDatePickerManager";
  private static final int SCROLL = 1;

  @Override
  public String getName() {
    return REACT_CLASS;
  }

  @NonNull
  @Override
  protected SingleDateAndTimePicker createViewInstance(@NonNull ThemedReactContext reactContext) {
    return new SingleDateAndTimePicker(new LinearLayout.LayoutParams(
      RelativeLayout.LayoutParams.MATCH_PARENT,
      RelativeLayout.LayoutParams.MATCH_PARENT
    ));
  }


  @ReactPropGroup(names = {DateProp.name, ModeProp.name, LocaleProp.name, MaximumDateProp.name,
    MinimumDateProp.name, FadeToColorProp.name, TextColorProp.name, UtcProp.name, MinuteIntervalProp.name,
    VariantProp.name, DividerHeightProp.name, Is24hourSourceProp.name
  })
  public void setProps(SingleDateAndTimePicker picker, int index, Dynamic value) {
    updateProp("setProps", picker, index, value);
  }

  @ReactPropGroup(names = {"height"}, customType = "Style")
  public void setStyle(SingleDateAndTimePicker view, int index, Dynamic value) {
    updateProp("setStyle", view, index, value);
  }

  @Override
  public Map<String, Integer> getCommandsMap() {
    return MapBuilder.of("scroll", SCROLL);
  }

  @Override
  protected void onAfterUpdateTransaction(SingleDateAndTimePicker pickerView) {
    super.onAfterUpdateTransaction(pickerView);
    try {
      pickerView.update();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void receiveCommand(final SingleDateAndTimePicker view, int command, final ReadableArray args) {
    if (command == SCROLL) {
      int wheelIndex = args.getInt(0);
      int scrollTimes = args.getInt(1);
      view.scroll(wheelIndex, scrollTimes);
    }
  }

  public Map getExportedCustomBubblingEventTypeConstants() {
    return MapBuilder.builder()
      .put("dateChange", MapBuilder.of("phasedRegistrationNames",
        MapBuilder.of("bubbled", "onChange")
        )
      ).build();
  }

  private void updateProp(String methodName, SingleDateAndTimePicker view, int index, Dynamic value) {
    String[] propNames = getMethodAnnotation(methodName).names();
    String propName = propNames[index];
    view.updateProp(propName, value);
  }

  private ReactPropGroup getMethodAnnotation(String methodName) {
    Method[] methods = this.getClass().getMethods();
    Method method = null;
    for (Method m : methods) {
      if (m.getName().equals(methodName))
        method = m;
    }
    return method.getAnnotation(ReactPropGroup.class);
  }

}
