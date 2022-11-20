import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import { Button } from '../components';
import '../assets/style.css';
import {
  AutocompleteInput,
  CheckboxButtonInput,
} from '../components';
import { Code } from '../model/components/input';

const options: Code[] = [
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
  return (
    <>
      <h2>AutocompleteInput</h2>
      <AutocompleteInput options={autocompleteOptions} />
    </>
  );
};

const autocompleteOptions: string[] = [
  '안녕',
  '안녕하세요',
  '안녕!',
  '인녕',
  '정경진입니다.',
  'DevCalendar 화이팅',
  'develop',
  'develop',
  'develop',
  'develop',
  'develop',
  'develop',
];


export default Exam;