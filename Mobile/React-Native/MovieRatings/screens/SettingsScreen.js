import { Ionicons } from '@expo/vector-icons';
import * as React from 'react';
import { StyleSheet, Text, View, Button } from 'react-native';
import { RectButton } from 'react-native-gesture-handler';

import users from '../helpers/usersData'

export default function SettingsScreen() {
  const user = users[users.length-1]
  console.log(users)
  return (
      <View style={ styles.container }>
        <Text>Hello {user.login}</Text>
        <View style={styles.buttonSection}>
          <Button 
            style={styles.button} 
            title={"Log out"} 
            onPress={ () => {} } 
          />
        </View>
      </View>
  );
}

function OptionButton({ icon, label, onPress, isLastOption }) {
  return (
    <RectButton style={[styles.option, isLastOption && styles.lastOption]} onPress={onPress}>
      <View style={{ flexDirection: 'row' }}>
        <View style={styles.optionIconContainer}>
          <Ionicons name={icon} size={22} color="rgba(0,0,0,0.35)" />
        </View>
        <View style={styles.optionTextContainer}>
          <Text style={styles.optionText}>{label}</Text>
        </View>
      </View>
    </RectButton>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fafafa',
  },
  buttonSection: {
    marginTop: 20,
    justifyContent: 'center',
    alignItems: 'center'
},
});
