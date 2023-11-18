import React, { FC } from 'react';
import styles from './LoginView.module.scss';

interface LoginViewProps {}

const LoginView: FC<LoginViewProps> = () => (
  <div className={styles.LoginView}>
    LoginView Component
  </div>
);

export default LoginView;
