import Typography from "@mui/material/Typography";
import Stack from "@mui/material/Stack";
import TextField from "@mui/material/TextField";
import Button from "@mui/material/Button";

import {fetcher} from "../utils/fetcher";

import {useState} from "react";

const TextInput = ({label, value, onChange}) => {
    return <TextField
        fullWidth
        required
        label={label}
        value={value}
        onChange={(event) => {
            onChange(event.target.value);
        }}
    />
}

const SignUp = () => {
    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [password, setPassword] = useState('');
    const [matchingPassword, setMatchingPassword] = useState('');
    const [email, setEmail] = useState('');

    const onSubmit = async () => {
        const res = await fetcher.post(`/register`, {
            firstName, lastName, email, password,
            matchingPassword,
        })
            .then(({data}) => {
                console.log(data);
            })
            .catch(console.error);
    }

    return <>
        <Typography variant="h5" gutterBottom>
            Простая регистрация на React и Spring
        </Typography>
        <Stack spacing={2} direction="column">
            <TextInput label={'Имя'} value={firstName} onChange={setFirstName}/>
            <TextInput label={'Фамилия'} value={lastName} onChange={setLastName}/>
            <TextInput label={'Почта'} value={email} onChange={setEmail}/>
            <TextInput label={'Пароль'} value={password} onChange={setPassword}/>
            <TextInput label={'Еще раз пароль'} value={matchingPassword} onChange={setMatchingPassword}/>
            <Button variant="contained" onClick={onSubmit}>Зарегистрироваться</Button>
        </Stack>
    </>
}

export default SignUp;
