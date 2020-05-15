import React, { Component } from 'react';
import { Text, View } from 'react-native';
import { styles } from './assets/css/stylesheet';
import Title from './components/title';
import Timer from './components/timer';
import Label from './components/label';
import SelectTimer from './components/selectTimer';
import Cta from './components/cta';


function leftPadding( val ) {
    if ( parseInt( val ) < 10 ) {
        return "0" + val.toString();
    } else {
        return val.toString();
    }
}

function getTime( val ) {
    return leftPadding( val ) + ":00";
  }

export default class App extends Component {

    constructor( props ) {
        super( props );
        this.state = {
            currentTime: "25:00",
            workTime: "25:00",
            breakTime: "05:30",
            working: true,
            timer: null,
            break: false,
            work: false,
        }
        this.setWorkTime = this.setWorkTime.bind( this );
        this.setBreakTime = this.setBreakTime.bind( this );
        this.work = this.work.bind( this );
        this.countDown = this.countDown.bind( this );
        this.changeStatus = this.changeStatus.bind( this );
        this.break = this.break.bind( this );
        this.reset = this.reset.bind( this );
    }

    setWorkTime( val ) {
        let time = getTime( val );
        
        console.log( time );

        this.setState({
            workTime: time
        })
        
        if( !this.state.timer ) {
            this.setState({
                currentTime: time
            })
        }
    }

    setBreakTime( val ) {
        let time = getTime( val );

        this.setState({
            breakTime: time
        })
    }

    work() {
        if( this.state.work === false || this.state.break === true ) {
            this.setState({
                timer: setInterval( this.countDown, 1000),
                break: false,
                work: true,
                working: true
            })
        }
    }

    countDown() {
        if( this.state.currentTime === "00:00" && this.state.work === true ) {
            this.changeStatus()
        } else {
            let sec = this.state.currentTime.slice( 3 );
            let min = this.state.currentTime.slice( 0, 2 );

            if( sec === "00" ) {
                let newMin = leftPadding( parseInt( min ) - 1 );
                let newTime = newMin + ":59";
                this.setState({
                    currentTime: newTime
                })
            } else {
                let newSec = leftPadding( parseInt( sec ) - 1 );
                let newTime = min + ":" + newSec;
                this.setState({
                    currentTime: newTime
                })
            }
        }
    }

    changeStatus() {
        if( this.state.working ) {
            this.setState({
                working: false,
                currentTime: this.state.breakTime
            })
        } else {
            this.setState({
                working: true,
                currentTime: this.state.workTime
            })
        }
    }

    break() {
        if( this.state.break === false && this.state.work === true ) {
            clearInterval( this.state.timer );
            this.setState({
                break: true,
                timer: null,
                working: false
            })
        } else if( this.state.break === true && this.state.work === false ) {
            this.work();
        }
    }

    reset() {
        this.break();
        this.setState({
            currentTime: this.state.workTime,
            work: false,
            break: false,
            working: true
        })
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
                    <SelectTimer 
                        value={ Number( this.state.workTime.slice( 0, 2 ) ).toString() }
                        onChangeText={ this.setWorkTime }
                    />
                </View>

                <View style={ styles.selectContainer }>
                    <Text style={ styles.selectTitle }>Break time :</Text>
                    <SelectTimer 
                        value={ Number( this.state.breakTime.slice( 0, 2 ) ).toString() }
                        onChangeText={ this.setBreakTime }
                    />
                </View>

                <View style={ styles.actionContainer }>
                    <Cta title="Play" onPress={ this.work }/>
                    <Cta title="Pause" onPress={ this.break } />
                    <Cta title="Reset" onPress={ this.reset } />
                </View>
            </View>
        )
    }
}
