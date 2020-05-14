import React from 'react';
import { Text } from 'react-native';
import { styles } from '../assets/css/stylesheet';
function action(props) {
    if (this.props.working) {
        return (<Text style={styles.label}>Work &#128512;</Text>);
    }
    else {
        return (<Text style={styles.label}>Break</Text>);
    }
}
