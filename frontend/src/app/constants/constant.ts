export const BACKEND_CONFIG_ROOT = "http://localhost:8080"
export const BACKEND_CONFIG_URL = `${BACKEND_CONFIG_ROOT}/config`
export const BACKEND_CREATE_EVENT = `${BACKEND_CONFIG_ROOT}/events`
export const BACKEND_FUTURE_EVENTS = `${BACKEND_CONFIG_ROOT}/events/read-all-events-after-today`
export const BACKEND_PAST_EVENTS = `${BACKEND_CONFIG_ROOT}/events/read-all-events-before-today`
export const BACKEND_FIND_EVENT_BY_ID = `${BACKEND_CONFIG_ROOT}/findEventById/{eventID}`
export const BACKEND_UPDATE_PRIVATE_CLIENT_BY_ID = `${BACKEND_CONFIG_ROOT}/private-clients/update-private-client-by-id`
export const BACKEND_GET_PRIVATE_CLIENT_BY_ID = `${BACKEND_CONFIG_ROOT}/private-clients/find-private-client-by-id`
