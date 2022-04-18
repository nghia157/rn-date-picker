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
        locale="en"
        date={new Date()}
        mode="datetime"
        onConfirm={(date) => {
          console.log(date);
        }}
        textColor="#000000"
        backgroundColor="red"
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
