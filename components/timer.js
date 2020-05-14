import React from 'react';
import { Text } from 'react-native';
import { styles } from '../assets/css/stylesheet';

export default class Timer extends React.Component {
    render() {
        return(
            <Text style={ styles.timer }>
                { this.props.currentTime }
            </Text>
        )
    }
}