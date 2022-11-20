import React, { useState } from 'react';
import { AutocompleteInputProps, DropdownInputProps } from '../../model/components/input';
import styles from './AutocompleteInput.module.css';

const AutocompleteInput: React.FC<AutocompleteInputProps> = ({ options }) => {
  const [inputValue, setInputValue] = useState('');
  const [isDropdownOpened, setIsDropdownOpened] = useState(false);

  const matchedOptions = (inputValue: string) => {
    if (!inputValue) return [];
    return options.filter(o => o.includes(inputValue));
  };

  const onInputChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const currentInputValue = e.target.value;
    setIsDropdownOpened(matchedOptions(currentInputValue).length > 0);
    setInputValue(currentInputValue);
  };

  return (
    <div className={styles.container}>
      <input type="text" value={inputValue} onChange={onInputChange} />
      {isDropdownOpened
      ? <DropdownInput
          className={`${isDropdownOpened ? styles.open : styles.hide}`}
          options={matchedOptions(inputValue)}
          onChange={setInputValue}
        />
      : inputValue && <EmptyDropdown />}
    </div>
  );
};

const DropdownInput: React.FC<DropdownInputProps> = ({ options, className, onChange }) => {
  const onDropdownSelect = (selected: string) => {
    if (!onChange) return;
    onChange(selected);
  };

  return (
    <ul className={`${styles.dropdown} ${className}`}>
      {options.map((option, i) => (
        <li key={i.toString()} onClick={() => onDropdownSelect(option)}>{option}</li>
      ))}
    </ul>
  );
};

const EmptyDropdown: React.FC<{ message?: string; }> = ({ message = 'No Options' }) => {
  return <DropdownInput options={[message]} />;
};

export default AutocompleteInput;