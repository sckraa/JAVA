import { StyleSheet } from 'react-native';

export const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#fff',
        alignItems: 'center',
        justifyContent: 'center',
    },
    title: {
        fontSize: 40,
        letterSpacing: 3,
    },
    timer: {
        fontSize: 45,
        paddingHorizontal: 75,
        paddingVertical: 10,
        marginTop: 30,
        backgroundColor: '#c3c3c3',
        borderRadius:5,
        borderBottomWidth: 3,
        borderTopWidth: 3,
        borderLeftWidth: 3,
        borderRightWidth: 3,
        shadowColor: "#000",
        shadowOffset: {
            width: 0,
            height: 12,
        },
        shadowOpacity: 0.60,
        shadowRadius: 16.65,
        elevation: 7,
    },
    labelContainer: {
        marginTop: 30,
        marginBottom: 20,
    },
    label: {
        fontSize: 25,
    },
    selectContainer: {
        flexDirection: 'row',
        alignItems: 'center',
        justifyContent: 'center',
        marginTop: 10
    },
    selectTitle: {
        marginRight: 25,
        fontSize: 18
    },
    actionContainer: {
        flexDirection: 'row',
        alignItems: 'center',
        justifyContent: 'center',
    },
    buttonsView: {
        marginTop: 50,
        marginHorizontal: 15,
    },
});