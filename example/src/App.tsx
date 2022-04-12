// @ts-nocheck
import * as React from 'react';
import { StyleSheet, View } from 'react-native';
import RCTDatePickerIOS from './DatePickerIOS';

export default function App() {
  return (
    <View style={styles.container}>
      <RCTDatePickerIOS
        modal={true}
        open={true}
        date={new Date()}
        confirmText="confirm"
        cancelText="Cancel"
        mode="datetime"
        onConfirm={(date) => {}}
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
