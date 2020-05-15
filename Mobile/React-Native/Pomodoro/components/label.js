import React, { Component } from 'react';
import { Text } from 'react-native';
import { styles } from '../assets/css/stylesheet';

export default class Label extends Component {
    render() {
        return(
            <Text style={ styles.label }>
                { this.props.working ? <Text style={ styles.label }> Work &#129304; </Text> : <Text style={ styles.label }> Break &#128564; </Text>}
            </Text>
        )
    }
}