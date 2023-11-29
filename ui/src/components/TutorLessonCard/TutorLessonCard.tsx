import React, { FC } from "react";
import styles from "./TutorLessonCard.module.scss";
import { Badge, Button, Card, Group, Image, List, Text } from "@mantine/core";
import { DatePicker } from "@mantine/dates";
import { IconCheck, IconCode, IconCross, IconX } from "@tabler/icons-react";

interface TutorLessonCardProps {}

const TutorLessonCard: FC<TutorLessonCardProps> = () => (
  <div className={styles.TutorLessonCard}>
    <Card
      className="mx-auto max-w-lg"
      shadow="xl"
      padding="md"
      radius="md"
      withBorder
    >
      <Group justify="space-between" mt="md" mb="xs">
        <Group>
          <IconCode size={40}></IconCode>
          <Text size="xl" fw={800}>
            Programación
          </Text>
        </Group>
        <Badge color="green" variant="light">
          Principiante
        </Badge>
      </Group>

      <div className="h-2"/>

      <Group align="start" justify="space-between">
        <div>
          <Text size="xl" fw={800}>
            Fecha
          </Text>
          <Group justify="space-around">
            <DatePicker size="xs" defaultDate={new Date(2023, 2, 23)} />
          </Group>
        </div>
        <div>
          <Text size="xl" fw={800}>
            Dudas
          </Text>

          <List type="ordered">
            <List.Item>
              <Text size="md">Lorem ipsum dolor sit amet</Text>
            </List.Item>
            <List.Item>
              <Text size="md">Lorem ipsum dolor sit amet</Text>
            </List.Item>
            <List.Item>
              <Text size="md">Lorem ipsum dolor sit amet</Text>
            </List.Item>
          </List>
        </div>
      </Group>

      <div className="h-2"/>

      <Group justify="space-between">
        <div>
          <Text size="xl" fw={800}>
            Duración Aproximada
          </Text>
          <Text size="md">Lorem ipsum dolor sit amet</Text>
        </div>
        <div>
          <Text ta="center" size="xl" fw={800}>
            Costo
          </Text>
          <Badge className="mx-auto" color="green" size="xl" variant="light">
            $100.00
          </Badge>
        </div>
      </Group>

      <Card.Section>
        <Group className="m-2" justify="space-between" grow>
          <Button variant="outline" size="xl" color="green" mt="md" radius="md">
            <IconCheck />
          </Button>
          <Button variant="outline" size="xl" color="red" mt="md" radius="md">
            <IconX />
          </Button>
        </Group>
      </Card.Section>
    </Card>
  </div>
);

export default TutorLessonCard;
