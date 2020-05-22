import React, {Component} from 'react';
import {StyleSheet, TextInput, Text, View, Button} from 'react-native';

import users from '../helpers/usersData'

export default class Login extends Component {
    constructor(props) {
        super(props)
        this.state = {
            login: "",
            password: "",
            error: false,
            logged: false
        }
    }

    onChangeLogin(login) {
        this.setState({
            login: login
        })
    }

    onChangePassword(password) {
        this.setState({
            password: password
        })
    }

    logIn() {
        if(this.state.login !== "" && this.state.password !== "") {
            var user = {
                login: this.state.login,
                password: this.state.password
            }
            users.push(user);
            this.setState({
                logged: true,
                error: false
            })
        } else {
            this.setState({
                error: true,
                logged: false
            })
        }
    }

    errorConnection() {
        if( this.state.error ) {
            return(
                <Text style={styles.errorMessage}>Please complete all fields !</Text>
            )
        }
    }

    logged() {
        if(this.state.logged) {
            return(
                <Text style={styles.successMessage}>You're well connected</Text>
            )
        }
    }

    render() {
        return (
            <View style={styles.loginContainer}>
                <Text style={styles.label}>Login :</Text>
                <TextInput style={styles.textInput} onChangeText={ (login) => this.onChangeLogin(login) } />
                
                <Text style={styles.label}>Password :</Text>
                <TextInput style={styles.textInput} secureTextEntry={true} onChangeText={ (password) => this.onChangePassword(password) }/>

                <View style={styles.button}>
                    <Button title={"Log in"} onPress={ () => this.logIn() } />
                </View>
                {this.errorConnection()}
                {this.logged()}
            </View>
        )
    }
}

const styles = StyleSheet.create({
    loginContainer: {
        flex: 1,
    },
    label: {
        marginLeft: 15,
        marginVertical: 15,
        fontSize: 18
    },  
    textInput: {
        marginLeft: 15,
        marginRight: 15,
        height: 40,
        borderColor: '#000',
        borderRadius: 5,
        borderWidth: 1,
        paddingLeft: 10
    },
    button: {
        width: 100,
        marginTop: 20,
        alignItems: 'center'
    },
    errorMessage: {
        marginHorizontal: 15,
        marginVertical: 25,
        textAlign: "center",
        fontSize: 20,
        paddingHorizontal: 15,
        paddingVertical: 15,
        backgroundColor: "red"
    },
    successMessage: {
        marginHorizontal: 15,
        marginVertical: 25,
        textAlign: "center",
        fontSize: 20,
        paddingHorizontal: 15,
        paddingVertical: 15,
        backgroundColor: "green"
    }
})