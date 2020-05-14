import React from 'react';
import { Text } from 'react-native';
import { styles } from '../assets/css/stylesheet';

export default class Title extends React.Component {
    render() {
        return(
            <Text style={ styles.title }>Pomodoro</Text>
        )
    }
}