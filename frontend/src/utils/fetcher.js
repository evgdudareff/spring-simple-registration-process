import axios from 'axios'

const baseURL = 'http://localhost:80/api/v1';

export const fetcher = axios.create({ baseURL })