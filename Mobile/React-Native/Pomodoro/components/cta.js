import React, { Component } from 'react';
import { View, Button } from 'react-native';
import { styles } from '../assets/css/stylesheet';

export default class Cta extends Component {
    render() {
        return(
            <View style={ styles.buttonsView }>
                <Button title={ this.props.title }  />
            </View>
        )
    }
}