import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import { Button } from '../components';
import '../assets/style.css';
import {
  AutocompleteInput,
  CheckboxButtonInput,
  Calendar,
} from '../components';
import { LabelValuePair } from '../model/components/input';

const options: LabelValuePair[] = [
  { label: 'Code 1', value: 'code 1' },
  { label: 'Code 2', value: 'code 2' },
  { label: 'Code 3', value: 'code 3' },
  { label: 'Code 4', value: 'code 4' },
];

const Exam = () => (
  <div>
    <div>
      <h1>React Router</h1>
      <h2>Link</h2>
      <Link to="/">Home</Link>
    </div>

    <div>
      <h1>Button</h1>
      <h2>Size</h2>
      <div className="wrap">
        <Button label="small" size="small" />
        <Button label="default" />
        <Button label="large" size="large" />
      </div>

      <h2>Event</h2>
      <div className="wrap">
        <Button label="onClick" onClick={() => console.log('Button is clicked.')}/>
      </div>
    </div>

    <section>
      <h1>Input</h1>
      <CheckboxButtonInputExam />
      <AutocompleteInputExam />
      <h1>Calendar</h1>
      <CalendarExam />
    </section>
  </div>
);

const CheckboxButtonInputExam: React.FC = () => {
  const [selected, setSelected] = useState<string[]>([])
  return (
    <>
      <h2>CheckboxButtonInput</h2>
      <pre>{selected}</pre>
      <div className="wrap">
        <CheckboxButtonInput
          options={options}
          selected={selected}
          onChange={setSelected}
          />
      </div>
    </>
  );
};

const AutocompleteInputExam: React.FC = () => {
  const [selected, setSelected] = useState<LabelValuePair | null>(null);
  return (
    <>
      <h2>AutocompleteInput</h2>
      {selected && <pre>{selected && `label: ${selected.label}, value: ${selected.value}`}</pre>}
      <AutocompleteInput
        options={autocompleteOptions}
        onChange={setSelected} />
    </>
  );
};

const autocompleteOptions: LabelValuePair[] = [
  { label: '네이버', value: 'naver' },
  { label: '네이버2', value: 'naver2' },
  { label: '카카오', value: 'kakao' },
  { label: '카카오2', value: 'kakao2' },
  { label: '카카오3', value: 'kakao3' },
  { label: '라인', value: 'line' },
  { label: '쿠팡', value: 'coupang' },
  { label: '배달의민족', value: 'woowa-brothers' },
];

const CalendarExam: React.FC = () => {
  return (
    <>
      <Calendar />
    </>
  );
};

export default Exam;