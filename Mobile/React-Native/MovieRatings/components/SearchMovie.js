import * as React from 'react';
import {StyleSheet, View, Text, TextInput, Button, FlatList} from 'react-native';
import moviesData from '../helpers/moviesData';

import MovieItem from '../components/MovieItem';

export default class SearchMovie extends React.Component {

    
    constructor(props) {
        super(props);
        this.state = {
            movies: []
        }
    }

    search(title) {
        if(title === "") {
            this.setState({ movies: []});
        }
        else {
            var resultResearch = [];
            moviesData.forEach(movie => {
                if(movie.title.toLowerCase().includes(title.toLowerCase(), 0)){
                    resultResearch.push(movie);
                }
            });
            this.setState({
                movies: resultResearch
            });
        }
    }

    show() {
        if (this.state.movies.length > 0 ) {
            return(
                <FlatList
                    data={this.state.movies}
                    keyExtractor={(item) => item.id.toString()}
                    renderItem={({item}) => <MovieItem movie={item} displayMovieDetails={this.displayMoviesDetails}/>}
                />
            )
        } else {
            return(
                <Text style={styles.noResults}>No film matches your search</Text>
            )
        }
    }

    render() {
        return(
            <View style={styles.container}>
                <Text style={styles.label}>Title :</Text>
                <TextInput style={styles.textInput} placeholder="Title of the movie ..." onChangeText={ (title) => {this.search(title)} } />

                { this.show() }
            </View>
        )
    }
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#fff',
        marginBottom: 25
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
    noResults: {
        marginHorizontal: 15,
        marginVertical: 25,
        textAlign: "center",
        fontSize: 20,
        paddingHorizontal: 15,
        paddingVertical: 15,
        backgroundColor: "red"
    }
})