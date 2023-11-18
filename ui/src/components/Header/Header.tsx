import React, { FC } from 'react';
import styles from './Header.module.scss';
import { Button, Title } from '@mantine/core';
import { IconPhoto, IconUser } from '@tabler/icons-react';

interface HeaderProps {}

const Header: FC<HeaderProps> = () => (
  <div className={`${styles.Header} flex justify-between mx-8`}>
      <Title className='text-6xl'>
        Tutor Demo
      </Title>
      <Button leftSection={<IconPhoto size={14}/>}>Gallery</Button>
  </div>
);

export default Header;
