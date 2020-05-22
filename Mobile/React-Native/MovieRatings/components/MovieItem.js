import * as React from 'react';
import {StyleSheet, View, Image, Text} from 'react-native';

export default function MovieItem(props){
  const movie = props.movie;
  return (
    <View style={styles.container}>
      <Image
        style={styles.image}
        source={{uri: "image"}}
      />
      <View style={styles.contentContainer}>
        <View style={styles.headerContainer}>
          <Text style={styles.title}>{movie.title}</Text>
          <Text style={styles.vote}>{movie.vote_average}</Text>
        </View>
        <View style={styles.descriptionContainer}>
          <Text style={styles.description} numberOfLines={4}>{movie.overview}</Text>
        </View>
        <View style={styles.dateContainer}>
          <Text style={styles.date}>Sorti le {movie.release_date}</Text>
        </View>
      </View>
    </View>
  )
}

const styles = StyleSheet.create({
    container: {
      height: 200,
      flexDirection: 'row',
      marginVertical: 15,
    },
    image: {
      width: 120,
      height: 180,
      margin: 5,
      backgroundColor: 'gray'
    },
    contentContainer: {
      flex: 1,
      margin: 5
    },
    headerContainer: {
      flex: 3,
      flexDirection: 'row'
    },
    title: {
      fontWeight: 'bold',
      fontSize: 18,
      flex: 1,
      flexWrap: 'wrap',
      paddingRight: 5
    },
    vote: {
      fontWeight: 'bold',
      fontSize: 20,
      color: '#F25F5C'
    },
    descriptionContainer: {
      flex: 7
    },
    description: {
      fontStyle: 'italic',
      color: '#666666'
    },
    dateContainer: {
      flex: 1
    },
    date: {
      textAlign: 'right',
      fontSize: 14
    }
  })