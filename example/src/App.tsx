// @ts-nocheck
import * as React from 'react';
import { Platform, StyleSheet, View } from 'react-native';
import DatePickerAndroid from './DatePickerAndroid';
import DatePickerIOS from './DatePickerIOS';

const DatePicker = Platform.select({
  android: DatePickerAndroid,
  ios: DatePickerIOS,
});

export default function App() {
  return (
    <View style={styles.container}>
      <DatePicker
        androidVariant="iosClone"
        date={new Date()}
        confirmText="confirm"
        cancelText="Cancel"
        mode="datetime"
        onConfirm={(date) => {
          console.log(date);
        }}
        onCancel={() => {}}
      />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});
