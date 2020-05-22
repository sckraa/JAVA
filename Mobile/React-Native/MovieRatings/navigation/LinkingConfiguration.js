import * as Linking from 'expo-linking';

export default {
  prefixes: [Linking.makeUrl('/')],
  config: {
    Root: {
      path: 'root',
      screens: {
        Account: 'account',
        Movie: 'movie',
        AddMovie: 'addmovie',
        Search: 'search'
      },
    },
  },
};
