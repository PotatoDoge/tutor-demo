import React, { FC } from 'react';
import styles from './DevelopmentView.module.scss';
import TutorLessonCard from '../TutorLessonCard/TutorLessonCard';

interface DevelopmentViewProps {}

const DevelopmentView: FC<DevelopmentViewProps> = () => (
  <div className={styles.DevelopmentView}>
    <TutorLessonCard />
  </div>
);

export default DevelopmentView;
