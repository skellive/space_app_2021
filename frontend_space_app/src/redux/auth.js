import axios from 'axios';

const init = {
    isAuthenticated: false,
    user: {},
    token: '',
    error: '',
}

const LOGIN = 'LOGIN';
const LOGOUT = 'LOGOUT';

export const auth = (state = init, action) => {
    switch (action.type) {
        case LOGIN:
            return {
                ...state,
                isAuthenticated: true,
                user: action.payload.user,
                token: action.payload.token,
                error: '',
                loading: false,
                isAdmin: action.payload.user.isAdmin,
            }
        case LOGOUT:
            return init;
        }
}