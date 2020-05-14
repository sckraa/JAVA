import React, { Component } from 'react';
import { TextInput } from 'react-native';
import { styles } from '../assets/css/stylesheet';

export default class SelectTimer extends Component {
    render() {
        return(
            <TextInput style={ styles.selectInput }
                placeholder="Chose time"
                placeholderTextColor='red'
                underlineColorAndroid='transparent'
                keyboardType='numeric'
                maxLength={ 2 }
            />
        )
    }
}