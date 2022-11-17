import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import { Button } from '../components';
import '../assets/style.css';
import CheckboxButtonInput from '../components/input/CheckboxButtonInput';
import {CheckableTagsInputProps, Code} from '../model/components/input';

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

export default Exam;