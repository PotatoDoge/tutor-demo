import React, { FC } from 'react';
import styles from './StudentAppointmentView.module.scss';

interface StudentAppointmentViewProps {}

const StudentAppointmentView: FC<StudentAppointmentViewProps> = () => (
  <div className={styles.StudentAppointmentView}>
    StudentAppointmentView Component
  </div>
);

export default StudentAppointmentView;
