import React, { FC } from 'react';
import styles from './TutorConfirmAppointmentView.module.scss';
import { Carousel } from '@mantine/carousel';
import TutorLessonCard from '../TutorLessonCard/TutorLessonCard';

interface TutorConfirmAppointmentViewProps {}

const TutorConfirmAppointmentView: FC<TutorConfirmAppointmentViewProps> = () => (
  <div className={styles.TutorConfirmAppointmentView}>
    <Carousel
    withIndicators
    loop
    slideSize="70%"
    slideGap="sm"
    initialSlide={2}
    align="center"
    slidesToScroll={1}
    >
      <Carousel.Slide>
        <TutorLessonCard />
      </Carousel.Slide>
      <Carousel.Slide>
        <TutorLessonCard />
      </Carousel.Slide>
      <Carousel.Slide>
        <TutorLessonCard />
      </Carousel.Slide>
      <Carousel.Slide>
        <TutorLessonCard />
      </Carousel.Slide>
    </Carousel>
  </div>
);

export default TutorConfirmAppointmentView;