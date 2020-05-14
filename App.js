import React, { Component } from 'react';
import { StyleSheet, Text, View } from 'react-native';
import { styles } from './assets/css/stylesheet';
import Title from './components/title';
import Timer from './components/timer';
import Label from './components/label';
import SelectTimer from './components/selectTimer';
import Cta from './components/cta';

export default class App extends Component {

    constructor( props ) {
        super( props );
        this.state = {
            currentTime: "30:00",
            working: true,
        }
    }


    render() {
        return(
            <View style={ styles.container }>
                <Title/>
                
                <Timer currentTime={ this.state.currentTime }/>

                <View style={ styles.labelContainer }>
                    <Label working={ this.state.working } />
                </View>

                <View style={ styles.selectContainer }>
                    <Text style={ styles.selectTitle }>Work time :</Text>
                    <SelectTimer />
                </View>

                <View style={ styles.selectContainer }>
                    <Text style={ styles.selectTitle }>Break time :</Text>
                    <SelectTimer />
                </View>

                <View style={ styles.actionContainer }>
                    <Cta title="Play" />
                    <Cta title="Pause" />
                    <Cta title="Reset" />
                </View>
            </View>
        )
    }
}
