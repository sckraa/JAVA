import * as React from 'react';
import {StyleSheet, View, Text, TextInput, Button, Alert} from 'react-native';
import movies from '../helpers/moviesData';

export default class FormMovie extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            movieTitle: "",
            movieSummary: "",
            movieNote: null,
            movieDate: "",
            formValid: false,
        }
    }

    verifyForm() {
        if(this.state.movieTitle !== "" && this.state.movieSummary !== "" && this.state.movieNote !== null && this.state.formValid) {
            this.addMovieToList();
        } else {
            if(this.state.movieTitle === "") {
                return( <Text style={styles.errorForm}>Please rename the title field !</Text> )
            } else if(this.state.movieSummary === "") {
                return( <Text style={styles.errorForm}>Please rename the summary field !</Text> )
            } else if(this.state.movieNote === null) {
                return( <Text style={styles.errorForm}>Please rename the note field !</Text> )
            } else {
                this.setState({
                    formValid: true,
                })
            }
        }
        
    }

    addMovieToList() {
        movies.push({
            id: movies.length+1,
            title: this.state.movieTitle,
            overview: this.state.movieSummary,
            vote_average: this.state.movieNote,
            release_date: this.state.movieDate === "" ? "unknown" : this.state.movieDate,
        })

        this.setState({
            movieTitle: "",
            movieSummary: "",
            movieNote: null,
            movieDate: "",
            formValid: false
        })
    }

    onChangeTitle(title) {
        this.setState({movieTitle: title})
    }

    onChangeSummary(summary) {
        this.setState({movieSummary: summary})
    }

    onChangeNote(note) {
        var note = parseFloat(note)
        
        if(note >= 0 && note <= 10)
            this.setState({movieNote: note})
        else
            Alert.alert("Enter a note between 0 and 10");
    }

    onChangeDate(date) {
        this.setState({movieDate: date})
    }

    onChangePoster(poster) {
        this.setState({moviePoster: poster})
    }
    
    render() {
        return(
            <View style={styles.container}>
                <Text style={styles.label}>Title : *</Text>
                <TextInput style={styles.textInput} placeholder="Title of the movie ..." onChangeText={ title => this.onChangeTitle(title) } />
                
                <Text style={styles.label}>Summary : *</Text>
                <TextInput style={styles.textInput} placeholder="Summary ..." onChangeText={ summary => this.onChangeSummary(summary) }/>
            
                <Text style={styles.label}>Release date :</Text>
                <TextInput style={styles.textInput} placeholder="Release date ..." onChangeText={ date => this.onChangeDate(date) }/>
            
                <Text style={styles.label}>Note : *</Text>
                <TextInput style={styles.textInput} placeholder="Note ..." keyboardType={'numeric'} onChangeText={ note => this.onChangeNote(note) }/>
    
                <Text style={styles.label}>Poster :</Text>
                <TextInput style={styles.textInput} placeholder="Poster ..." onChangeText={ poster => this.onChangePoster(poster) }/>
    
                <View style={styles.buttonSection}>
                    <Button 
                        style={styles.button} 
                        title={"Add the movie"} 
                        onPress={ () => this.verifyForm() } 
                    />
                </View>

                { this.state.formValid ? "" : this.verifyForm()}
            </View>
        )
    }
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#fff',
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
    buttonSection: {
        marginTop: 20,
        justifyContent: 'center',
        alignItems: 'center'
    },
    errorForm: {
        color: "red",
        textAlign: 'center',
        marginVertical: 20,
        fontSize: 20
    }
})