import React, { useState } from 'react';
import { AutocompleteInputProps, DropdownInputProps, LabelValuePair } from '../../model/components/input';
import styles from './AutocompleteInput.module.css';

const AutocompleteInput: React.FC<AutocompleteInputProps> = ({ options, onChange: onSelectedChange }) => {
  const [inputValue, setInputValue] = useState('');
  const [isDropdownOpened, setIsDropdownOpened] = useState(false);

  const matchedOptions = (inputValue: string) => {
    if (!inputValue) return [];
    return options.filter(o => o.label.includes(inputValue));
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
          onChange={option => {
            onSelectedChange(option);
            setInputValue(option.label);
          }}
        />
      : inputValue && <EmptyDropdown />}
    </div>
  );
};

const DropdownInput: React.FC<DropdownInputProps> = ({ options, className, onChange }) => {
  const onDropdownSelect = (selected: LabelValuePair) => {
    if (!onChange) return;
    onChange(selected);
  };

  return (
    <ul className={`${styles.dropdown} ${className}`}>
      {options.map(option => (
        <li key={option.value} onClick={() => onDropdownSelect(option)}>{option.label}</li>
      ))}
    </ul>
  );
};

const EmptyDropdown: React.FC<{ message?: string; }> = ({ message = 'No Options' }) => {
  const emptyOption: LabelValuePair = { label: message, value: message };
  return <DropdownInput options={[emptyOption]} />;
};

export default AutocompleteInput;