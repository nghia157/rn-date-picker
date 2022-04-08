import {
  requireNativeComponent,
  UIManager,
  Platform,
  ViewStyle,
} from 'react-native';

const LINKING_ERROR =
  `The package 'react-native-date-picker' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo managed workflow\n';

type DatePickerProps = {
  color: string;
  style: ViewStyle;
};

const ComponentName = 'DatePickerView';

export const DatePickerView =
  UIManager.getViewManagerConfig(ComponentName) != null
    ? requireNativeComponent<DatePickerProps>(ComponentName)
    : () => {
        throw new Error(LINKING_ERROR);
      };
